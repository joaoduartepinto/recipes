import axios from "axios";

export const URL_API = 'http://localhost:8080';

export function getRecipesHead(success, failure){
    axios.get(`${URL_API}/recipes`)
        .then(response => response)
        .then(response => success(response))
        .catch(error => failure(error.message));

}