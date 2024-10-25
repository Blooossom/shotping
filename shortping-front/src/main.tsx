import { createRoot } from "react-dom/client";
import "./assets/css/reset.css";
import "./assets/css/common.css";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import App from "./pages/App.tsx";
import Login from "./pages/Login.tsx";
import SignUp from "./pages/SignUp.tsx";


const queryClient = new QueryClient();
// @ts-ignore
const root = createRoot(document.getElementById("root"));

root.render(
  <QueryClientProvider client={queryClient}>
    <BrowserRouter basename="/">
      <Routes>
        <Route path="/main" element={<App />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signUp" element={<SignUp />} />
      </Routes>
    </BrowserRouter>
  </QueryClientProvider>,
);
