export const API_URL = import.meta.env.VITE_PUBLIC_APP_API_URL;

const API_BASE_URL = `${API_URL}/api`;

const Apis = {
  USER: {
    signUp: `${API_BASE_URL}/user/register`,
    login: `${API_BASE_URL}/user/login`,
    logout: `${API_BASE_URL}/user/logout`,
  },
};

export default Apis;
