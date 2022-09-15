<?php
class Validator
{
    function check_data_type($x, $y, $r)
    {
        if (!is_numeric($x) || !is_numeric($y) || !is_numeric($r)) {
            http_response_code(404);
            exit("Some values are not numeric!");
        }
    }

    function check_aceptability($x, $y, $r)
    {
        if (!isset($x) || !isset($y) || !isset($r)) {
            http_response_code(404);
            exit("Some values are not set in the request!");
        }
    }

    public function check_values($x, $y, $r)
    {
        $this->check_aceptability($x, $y, $r);
        $this->check_data_type($x, $y, $r);
    }
}

class HitChecker
{
    public function check($x, $y, $r)
    {
        $x_num = floatval($x);
        $y_num = floatval($y);
        $r_num = intval($r);
        $first_quarter_hit = false;
        $second_quarter_hit = false;
        $third_quarter_hit = false;

        if ($x_num >= -$r_num/2 && $x_num <= $r_num/2 && $y_num >= 0 && $y_num <= $r_num && $y_num == -2*$x_num + $r_num) {
            $first_quarter_hit = true;
        }

        if ($x_num <= 0 && $x_num >= -$r_num && $y_num >= 0 && $y_num <= $r_num / 2) {
            $second_quarter_hit = true;
        }

        if ($x_num <= 0 && $y_num <= 0 && $y_num == -(sqrt($r_num * $r_num - $x_num * $x_num))) {
            $third_quarter_hit = true;
        }

        return $first_quarter_hit || $second_quarter_hit || $third_quarter_hit;
    }
}

date_default_timezone_set('Europe/Moscow');

$start = microtime(true);

$current_time = date("H:i:s D:M:Y");

$x = $_POST['x'];
$y = $_POST['y'];
$r = $_POST['r'];

$validator = new Validator();
$hit_checker = new HitChecker();

$validator->check_values($x, $y, $r);

$checked_hit = $hit_checker->check($x, $y, $r) ? "TRUE" : "FALSE";

$compution_time = number_format(microtime(true) - $start, 8, ".", "") * 1000000;

exit("
        <tr>
            <th><time>$current_time</time></th>
            <th><time>$compution_time</time></th>
            <th>$x</th>
            <th>$y</th>
            <th>$r</th>
            <th>$checked_hit</th>
        </tr>");