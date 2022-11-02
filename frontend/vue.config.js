const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  devServer: {
    port: 8080,
  },
  transpileDependencies: true
})

module.exports = {
  devServer: {
    port: 8081
  }
}
