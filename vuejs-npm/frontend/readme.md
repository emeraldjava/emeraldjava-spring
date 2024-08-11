# frontend

## 11-08-2024

https://stackoverflow.com/questions/37329708/can-frontend-maven-plugin-use-node-npm-already-installed

    npm install -g @vue/cli

    cd frontend
    npm install
    npm run format
    npm run dev

package npm dist as a webjar 

- https://www.wissel.net/blog/2021/12/deploying-your-frontend-as-webjar.html
- https://medium.com/orienteer/working-with-npm-from-java-6acddd97f7a4
- https://stackoverflow.com/questions/42164938/step-by-step-guide-on-how-to-create-a-webjar-for-front-end-application

## Recommended IDE Setup

[VSCode](https://code.visualstudio.com/) + [Volar](https://marketplace.visualstudio.com/items?itemName=Vue.volar) (and disable Vetur).

## Type Support for `.vue` Imports in TS

TypeScript cannot handle type information for `.vue` imports by default, so we replace the `tsc` CLI with `vue-tsc` for type checking. In editors, we need [Volar](https://marketplace.visualstudio.com/items?itemName=Vue.volar) to make the TypeScript language service aware of `.vue` types.

## Customize configuration

See [Vite Configuration Reference](https://vitejs.dev/config/).

## Project Setup

```sh
npm install
```

### Compile and Hot-Reload for Development

```sh
npm run dev
```

### Type-Check, Compile and Minify for Production

```sh
npm run build
```

### Run Unit Tests with [Vitest](https://vitest.dev/)

```sh
npm run test:unit
```

### Lint with [ESLint](https://eslint.org/)

```sh
npm run lint
```
