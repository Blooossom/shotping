import { createRoot } from "react-dom/client";
import "./assets/css/reset.css";
import "./assets/css/common.css";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import App from "./pages/App.tsx";
import Login from "./pages/Login.tsx";


const queryClient = new QueryClient();
const root = createRoot(document.getElementById("root"));

root.render(
  <QueryClientProvider client={queryClient}>
    <BrowserRouter basename="/">
      <Routes>
        <Route path="/main" element={<App />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </BrowserRouter>
  </QueryClientProvider>,
);
