import { SignUp } from "../../types/user.type.ts";
import { useMutation } from "@tanstack/react-query";
import { signUp } from "../axios/user.ts";

const useSignUpMutation = (signupRequest: SignUp) => {
  const { mutate: signUpMutate } = useMutation({
    mutationFn: () => signUp(signupRequest),
  });

  return { signUpMutate };
};

export default useSignUpMutation;
