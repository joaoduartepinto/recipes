import React, {useReducer} from 'react';
import PropTypes from "prop-types";
import {Provider} from './AppContext';
import reducer from './AppReducer';

const initialState = {
    recipesHead: {
        content: []
    },
    recipe: {
        recipeName: '',
        ingredients: [],
        steps: '',
        timeOfCooking: ''
    },
    tableHeaders: {
        recipeName: 'Recipe Name',
        timeOfCooking: 'Time Of Cooking'
    }
};


const AppProvider = (props) => {

    const [state, dispatch] = useReducer(reducer, initialState);
    return (
        <Provider value={{
            state,
            dispatch
        }}>
            {props.children}
        </Provider>
    );
};

AppProvider.propTypes = {
    children: PropTypes.node,
};


export default AppProvider;