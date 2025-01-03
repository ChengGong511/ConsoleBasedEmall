# 项目简介
这是一个基于 Java 的简单购物管理系统，主要功能包括用户注册、用户登录、管理员登录、商品管理以及购物车功能。核心入口位于 [src/Main.java](src/Main.java)，工具方法集中在 [src/Tool.java](src/Tool.java)，商品逻辑在 [src/Goods.java](src/Goods.java)，用户逻辑在 [src/Users.java](src/Users.java) 与 [src/Users_Tools.java](src/Users_Tools.java)，管理员逻辑在 [src/Admin.java](src/Admin.java) 与 [src/Admin_Tools.java](src/Admin_Tools.java)。界面方法分别在 [src/Admin_Win.java](src/Admin_Win.java) 和 [src/Users_Win.java](src/Users_Win.java)。

## 使用说明
1. 在命令行中进入本项目根目录。  
2. 编译并运行主类:  
   ```bash
   javac src/*.java
   java src/Main
   ```
3. 按照提示选择功能并进行操作。  

## 文件结构
- [src/Main.java](src/Main.java)：项目入口  
- [src/Tool.java](src/Tool.java)：工具方法  
- [src/Goods.java](src/Goods.java)：商品类  
- [src/Users.java](src/Users.java)：用户类  
- [src/Admin.java](src/Admin.java)：管理员类  
- [src/Users_Tools.java](src/Users_Tools.java)：用户相关功能  
- [src/Admin_Tools.java](src/Admin_Tools.java)：管理员相关功能  
- [src/Users_Win.java](src/Users_Win.java) 和 [src/Admin_Win.java](src/Admin_Win.java)：用户与管理员交互界面
