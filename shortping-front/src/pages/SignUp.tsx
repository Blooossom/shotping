import { ReactElement, useState } from "react";
import { css } from "@emotion/css";
import { SignUp } from "../types/user.type.ts";
import { useForm } from "react-hook-form";
import useSignUpMutation from "../libs/query/useSignUpMutation.ts";
import { useToastStore } from "../store/ToastStore.ts";
import Toast from "../components/toast/Toast.tsx";

const Frame = css`
  display: grid;
  grid-template-rows: 23.54vh 1fr;
  background-color: #f0f0f9;
  position: relative;
  width: 100vw;
  height: 100vh;
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

const Label = css`
  display: flex;
  flex-direction: row;
  gap: 25px;
  justify-content: space-between;
  align-items: center;
`;

interface FormValues {
  signUpRequest: SignUp;
}

const SignUp = (): ReactElement => {
  const { setOpenToast, changeToastType, setToastContent } = useToastStore();

  const [signUpReq, setSignUpReq] = useState<SignUp>({
    userId: "",
    password: "",
    userName: "",
    email: "",
    phoneNum: "",
    address: "",
    addressDetail: "",
    gender: "",
    birth: "",
  });

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<FormValues>();

  const { signUpMutate } = useSignUpMutation(signUpReq);

  const onSubmit: (data: FormValues) => void = (data) => {
    setSignUpReq({
      userId: data.signUpRequest.userId,
      password: data.signUpRequest.password,
      userName: data.signUpRequest.userName,
      email: data.signUpRequest.email,
      phoneNum: data.signUpRequest.phoneNum,
      address: data.signUpRequest.address,
      addressDetail: data.signUpRequest.addressDetail,
      gender: data.signUpRequest.gender,
      birth: data.signUpRequest.birth,
    });

    try {
      signUpMutate();
      changeToastType("info");
      setToastContent("회원가입되었습니다.");
      setOpenToast();
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <>
      <Toast />
      <div className={Frame}>
        <section>Register</section>
        <form onSubmit={handleSubmit(onSubmit)}>
          <section
            className={css`
              display: flex;
              flex-direction: column;
              justify-content: center;
              align-items: center;
            `}
          >
            <div
              className={css`
                display: flex;
                flex-direction: column;
                gap: 30px;
              `}
            >
              <label className={Label}>
                <span className={css``}>아이디</span>
                <input
                  className={Form}
                  placeholder={"아이디를 입력해주세요."}
                  {...register("signUpRequest.userId", { required: true })}
                />
              </label>
              <label className={Label}>
                <span className={css``}>비밀번호</span>
                <input
                  className={Form}
                  placeholder={"비밀번호를 입력해주세요."}
                  {...register("signUpRequest.password", { required: true })}
                />
              </label>
              <label className={Label}>
                <span>이름</span>
                <input
                  className={Form}
                  placeholder={"이름을 입력해주세요."}
                  {...register("signUpRequest.userName", { required: true })}
                />
              </label>
              <label className={Label}>
                <span>이메일</span>
                <input
                  className={Form}
                  placeholder={"이메일을 입력해주세요."}
                  {...register("signUpRequest.email", { required: true })}
                />
              </label>
              <label className={Label}>
                <span>전화번호</span>
                <input
                  className={Form}
                  placeholder={"전화번호를 입력해주세요."}
                  {...register("signUpRequest.phoneNum", { required: true })}
                />
              </label>
              <label className={Label}>
                <span>주소</span>
                <input
                  className={Form}
                  placeholder={"주소 입력해주세요."}
                  {...register("signUpRequest.address", { required: true })}
                />
              </label>
              <label className={Label}>
                <span>상세주소</span>
                <input
                  className={Form}
                  placeholder={"상세주소를 입력해주세요."}
                  {...register("signUpRequest.addressDetail", {
                    required: true,
                  })}
                />
              </label>
              <label className={Label}>
                <span>성별</span>
                <input
                  className={Form}
                  placeholder={"성별을 입력해주세요."}
                  {...register("signUpRequest.gender", { required: true })}
                />
              </label>
              <label className={Label}>
                <span>생년월일</span>
                <input
                  className={Form}
                  placeholder={"생년월일 입력해주세요."}
                  {...register("signUpRequest.birth", { required: true })}
                />
              </label>
            </div>
            <button className={LoginButton} type="submit">
              회원가입
            </button>
            <button
              className={LoginButton}
              onClick={() => (location.href = "/login")}
            >
              뒤로
            </button>
          </section>
        </form>
      </div>
    </>
  );
};

export default SignUp;
