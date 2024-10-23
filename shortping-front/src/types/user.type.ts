export type SignUp = {
  userSeq: string;
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

export type Login = {
  userId: string;
  password: string;
};
