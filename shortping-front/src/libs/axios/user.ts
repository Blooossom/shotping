import { Login, SignUp } from "../../types/user.type.ts";
import axios from "axios";
import Apis from "../../data/Api.ts";

export const signUp = async (signUp: SignUp) => {
  try {
    const response = await axios.post(Apis.USER.signUp, signUp);
  } catch (error) {
    console.log(error);
  }
};

export const login = async (login: Login) => {
  try {
    const response = await axios.post(Apis.USER.login, login);

    if (typeof response.data === "string") {
      alert(response.data);
    } else {
      alert("로그인되었습니다.");
    }
  } catch (error) {
    console.log(error);
  }
};
