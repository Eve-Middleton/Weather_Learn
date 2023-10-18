# 天气示例(Weather_Learn)应用

这是一个采用 Jetpack Compose 编写的一个简单天气示例 APP，采用了百度地图的 API。
工作流程：
1. 从百度 API 拉取一周天气数据
2. 通过组件将数据可视化。

## 工作流程

1. 从百度 API 拉取一周天气数据：该应用通过与百度地图 API 进行通信，获取包含一周天气信息的数据。通过调用适当的 API 端点，应用能够获取指定地区的天气数据。

2. 通过组件将数据可视化：应用使用 Jetpack Compose 框架中的组件来将数据进行可视化展示。Jetpack Compose 是一种用于构建现代化 UI 的声明式 UI 工具包，它可以帮助开发者以简洁且灵活的方式构建用户界面。

   通过使用 Compose 中的各种组件，如文本组件、图像组件、列表组件等，应用能够将天气数据以易于理解和美观的方式呈现给用户。这些组件可以根据数据的变化自动更新界面，以提供实时的天气信息。

## 如何使用

1. 克隆本仓库到本地计算机：
    `git clone git@github.com:Eve-Middleton/Weather_Learn.git`

2. 打开 Android Studio，并导入该项目。

3. 在项目中，您需要提供百度地图 API 的访问密钥（AK）。请将您的 AK 替换 `WeatherViewModel.kt`文件中的`YOUR_BAIDU_MAP_API_KEY`字段。

4. 运行应用：

- 使用模拟器：在 Android Studio 中选择一个模拟器，并点击运行按钮。
- 使用物理设备：将您的 Android 设备连接到计算机，并点击运行按钮。

5. 应用将开始拉取天气数据并将其可视化展示。

## 技术栈

- Jetpack Compose：用于构建现代化 UI 的声明式 UI 工具包。
- 百度地图 API：用于获取地理位置和天气数据的 API。
- Kotlin：应用的主要编程语言。

## 贡献

欢迎对该项目进行贡献。如果您发现了 Bug，或者有新功能的建议，请提出 Issue 或提交 Pull Request。您的贡献将不胜感激。

## 许可证

该项目根据 [MIT 许可证](LICENSE) 进行许可，详情请参阅许可证文件。