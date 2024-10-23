import { ReactElement } from "react";
import { css } from "@emotion/css";

const Frame = css`
  display: flex;
    
`;
const Login = (): ReactElement => {
  return (
    <div>
      <section>header</section>
      <section
        className={css`
          display: flex;
          flex-direction: column;
          gap: 10px;
        `}
      >
        <input />
        <input />
      </section>
    </div>
  );
};

export default Login;
