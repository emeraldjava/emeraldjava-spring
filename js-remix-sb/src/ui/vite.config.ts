import {vitePlugin as remix} from "@remix-run/dev";
import {defineConfig} from "vite";
import tsconfigPaths from "vite-tsconfig-paths";

export default defineConfig({
  plugins: [
    remix({
      ssr: false, // use SPA mode - see https://remix.run/docs/en/main/guides/spa-mode
      future: {
        v3_fetcherPersist: true,
        v3_relativeSplatPath: true,
        v3_throwAbortReason: true,
      },
    }),
    tsconfigPaths(),
  ],
  build: {
    outDir: './../../target/classes/statix',
    emptyOutDir: true
  }
});
