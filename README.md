# middleware-todo
[![Quarkus Docker Image Build](https://github.com/mrvxk/middleware-todo/actions/workflows/build-service.yml/badge.svg)](https://github.com/mrvxk/middleware-todo/actions/workflows/build-service.yml)
[![Quarkus Native Docker Image Build](https://github.com/mrvxk/middleware-todo/actions/workflows/build-native-service.yml/badge.svg)](https://github.com/mrvxk/middleware-todo/actions/workflows/build-native-service.yml)
[![Quarkus Native Silicon Docker Image Build](https://github.com/mrvxk/middleware-todo/actions/workflows/build-native-service-silicon.yml/badge.svg)](https://github.com/mrvxk/middleware-todo/actions/workflows/build-native-service-silicon.yml)
[![UI Docker Image Build](https://github.com/mrvxk/middleware-todo/actions/workflows/build-ui.yml/badge.svg)](https://github.com/mrvxk/middleware-todo/actions/workflows/build-ui.yml)

### Start dev mode
Type in `todo-service`:
> quarkus dev

Type in `todo-ui`:
> yarn dev

### CI/CD
Within this project, GitHub Actions are employed to automate the build and deployment processes. Utilizing these actions, various images are constructed and subsequently made publicly available on the GitHub Container Registry. Specifically, the setup includes four distinct workflow files, each dedicated to creating different artifacts - the UI, a backend with JVM, and native builds for both arm64/amd64, along with a native build on a MacOS runner.

The MacOS runner proves to be essential because the native arm64 image does not operate as expected. However, even the image optimized and built on MacOS does not run on Apple Silicon Macs, due to its reliance on amd64 architecture instead of arm. 

Consequently, the image found in the registry has been locally built and pushed on an M1 Mac. If a Github runner with Apple Silicon were utilized, the pipeline would be operational in that context as well. However, setting up such a runner exceeds the requirements for this proof of concept, and I am currently satisfied with the outcomes achieved.
