import {ReactElement, useState} from "react";
import {css} from "@emotion/css";
import {useForm,} from "react-hook-form";
import useLoginMutation from "../libs/query/useLoginMutation.ts";
import {Login} from "../types/user.type.ts";

const Frame = css`
  display: grid;
  grid-template-rows: 23.54vh 1fr;
  background-color: #f0f0f9;
  position: relative;
  width: 100vw;
  height: 100vh;
`;

const Header = css`
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 48px;
  font-weight: 700;
`;

const Body = css`
  display: flex;
  flex-direction: column;
  gap: 20px;
  padding: 20px;
  font-size: 32px;
  font-weight: 500;
  align-items: center;
  justify-content: center;
`;

const Form = css`
  width: 324px;
  height: 48px;
  font-size: 24px;
`;

const LoginButton = css`
  width: 324px;
  height: 48px;
  border: 1px solid #000;
  border-radius: 12px;
`;

interface FormValues {
  loginReq: Login;
}

const Login = (): ReactElement => {
  const [loginReq, setLoginReq] = useState<Login>({
    userId: "",
    password: "",
  });
  const { loginMutate } = useLoginMutation(loginReq);
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<FormValues>();

  const onSubmit: (data: FormValues) => void = (data) => {
    setLoginReq({
      userId: data.loginReq.userId,
      password: data.loginReq.password,
    });

    loginMutate();
  };
  return (
    <div className={Frame}>
      <section className={Header}>Shortping</section>
      <form onSubmit={handleSubmit(onSubmit)}>
        <section className={Body}>
          <input
            className={Form}
            placeholder={"아이디를 입력해주세요."}
            {...register("loginReq.userId", { required: true })}
          />
          <input
            type={"password"}
            className={Form}
            placeholder={"비밀번호를 입력해주세요."}
            {...register("loginReq.password")}
          />
          <button className={LoginButton} type="submit">
            로그인
          </button>
        </section>
      </form>
    </div>
  );
};

export default Login;
