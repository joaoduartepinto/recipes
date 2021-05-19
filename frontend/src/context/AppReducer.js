import {FETCH_RECIPES_HEAD_FAILURE, FETCH_RECIPES_HEAD_SUCCESS} from './Actions'


function reducer(state, action) {
    switch (action.type) {
        case FETCH_RECIPES_HEAD_FAILURE:
            return {
                ...state,
                recipesHead: []
            }
        case FETCH_RECIPES_HEAD_SUCCESS:
            return {
                ...state,
                recipesHead: {
                    content: [...action.payload.data]}
            }
    }
}

export default reducer;