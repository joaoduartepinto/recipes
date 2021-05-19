import React, {useContext, useEffect} from 'react';
import AppContext from "../../context/AppContext";
import {fetchRecipeHead} from "../../context/Actions";

const Table = () => {

    const {state, dispatch} = useContext(AppContext);

    const {recipesHead, tableHeaders} = state;

    const {recipeName, timeOfCooking} = tableHeaders;

    useEffect(() => {
        fetchRecipeHead(dispatch);
        console.log(state)
    }, []);

    {/*if (recipesHead.data.length < 0) {
        return (
            <h1>There are no Recipes</h1>
        )
    } else {  */
    }
    return (
        <div>
            <table>
                <thead>
                <tr>
                    <th>{recipeName}</th>
                    <th>{timeOfCooking}</th>
                </tr>
                </thead>
                <tbody>
                {recipesHead.content?.map((recipe) => (
                    <tr key={recipe.recipeName}>
                        <td>{recipe.recipeName}</td>
                        <td>{recipe.timeOfCooking}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );

}

export default Table;