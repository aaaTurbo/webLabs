import {createBrowserRouter, RouterProvider} from "react-router-dom";
import Header from "./Header";
import AuthFetch, {getLogin} from "./auth/AuthFetch";
import MainAppFetcher, {LoadResults} from "./main/MainAppFetcher";
import React from "react";

export default function Routed(props) {

    const router = createBrowserRouter([{
        path: "lab4",
        element: <Header/>,
        children: [{
            index: true,
            element: <AuthFetch/>,
            loader: getLogin
        },
            {
                path: "main",
                element: <MainAppFetcher/>,
                loader: LoadResults
            }]
    }]);

    return <RouterProvider router={router}/>;
}