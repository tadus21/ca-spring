import {API_DOMAIN} from "./constants";


const post = async (url, requrst) => {

  // eslint-disable-next-line react-hooks/exhaustive-deps
  async function post(request) {
    const response = await fetch(`${API_DOMAIN}${url}`, {body: request, method: 'POST'});
    if (!response.ok) {
      throw Error(response.statusText);
    }
  }
};
export {post};