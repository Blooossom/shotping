import {defineConfig} from 'vite'
import react from '@vitejs/plugin-react-swc'

// https://vitejs.dev/config/
export default defineConfig({
  base: "/",
  server: {
    port: 4100,
    proxy: {
      "/api": {
        target: "http://localhost:8080",
        changeOrigin: true,
      },
    },
  },
  plugins: [react()],
  esbuild: {
    jsxInject: `import React from 'react'`,
  },
  build: {
    assetsInlineLimit: 0,
  },
});

