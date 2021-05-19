import React from 'react';
import ReactDOM from 'react-dom';
import App from "./components/App";
import AppProvider from "./context/AppProvider";

ReactDOM.render(
    <AppProvider>
        <React.StrictMode>
            <App/>
        </React.StrictMode>
    </AppProvider>,
    document.getElementById('root')
);
