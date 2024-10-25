export type User = {
  userSeq: string | null;
  userId: string;
  password: string;
  userName: string;
  email: string;
  phoneNum: string;
  address: string;
  addressDetail: string;
  gender: string;
  birth: string;
};

export type SignUp = Omit<User, "userSeq">;

export type Login = Pick<User, "userId" | "password">;
