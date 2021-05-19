import {getRecipesHead} from "./Service";

export const FETCH_RECIPES_HEAD_SUCCESS = 'FETCH_RECIPES_HEAD_SUCCESS';
export const FETCH_RECIPES_HEAD_FAILURE = 'FETCH_RECIPES_HEAD_FAILURE';

export function fetchRecipeHead(dispatch){
    getRecipesHead((res) => dispatch(fetchRecipeHeadSuccess(res)), (err) => dispatch(fetchRecipeHeadFailure(err.message)));
}

export function fetchRecipeHeadSuccess(recipesHead){
    return {
        type: FETCH_RECIPES_HEAD_SUCCESS,
        payload: {
            data: [...recipesHead]
        }
    }
}

export function fetchRecipeHeadFailure(message) {
    return {
        type: FETCH_RECIPES_HEAD_FAILURE,
        payload: {
            error: message
        }
    }
}