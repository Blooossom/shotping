import { Login } from "../../types/user.type.ts";
import { useMutation } from "@tanstack/react-query";
import { login } from "../axios/user.ts";

const useLoginMutation = (loginRequest: Login) => {
  const { mutate: loginMutate } = useMutation({
    mutationFn: () => login(loginRequest),
  });

  return { loginMutate };
};

export default useLoginMutation;
