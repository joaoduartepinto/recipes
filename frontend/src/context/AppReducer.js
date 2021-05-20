import {FETCH_RECIPES_HEAD_FAILURE, FETCH_RECIPES_HEAD_SUCCESS} from './Actions'


function reducer(state, action) {
    switch (action.type) {
        case FETCH_RECIPES_HEAD_FAILURE:
            return {
                ...state,
                recipesHead: {
                    content: []
                }
            }
        case FETCH_RECIPES_HEAD_SUCCESS:
            console.log(action)
            return {
                ...state,
                recipesHead: {
                    content: [...action.payload.data]
                }
            }
        default:
            return {...state}
    }
}

export default reducer;