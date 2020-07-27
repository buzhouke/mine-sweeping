# MineSweeper

学校项目实训布置的项目，扫雷

选用工具：GreenFoot

类设计图：

![](https://ftp.bmp.ovh/imgs/2020/07/79813bc78743b4c2.png)

实现效果图：

进入页：

![](https://ftp.bmp.ovh/imgs/2020/07/824b126b62509bfc.png)

规则查看：

![](https://ftp.bmp.ovh/imgs/2020/07/66758cee9b0b1d90.png)

游戏过程：

![](https://ftp.bmp.ovh/imgs/2020/07/d942bc555cef87e0.png)

游戏失败：

![](https://ftp.bmp.ovh/imgs/2020/07/8264f209d7768242.png)

游戏胜利：

![](https://ftp.bmp.ovh/imgs/2020/07/ce4f13159b2db635.png)

当时写的提交报告：

## 1.Introductions

​	As a public puzzle game, The goal of it is in the shortest time according to the number of the clicked block to find out all the non-thunder grid, while avoiding stepping on the thunder, stepping on a thunder that player lost the game.

RULE:

​	Mine Sweeper is a game that player could choose different difficult mode to start the game. Then system would introduce the rule of the game. When player press the key on the square then the game is formally start. When the block is clicked that player would know whether it is mine or not. If it doesn’t, a number appears on the square, which represents the number of mines in the 3-3 area around it (typically 8 cells, 5 cells for the side blocks, and 3 cells for the corner blocks). If the square is empty (equal to 0), the square adjacent to the square can be opened recursively. If the first square is mine, the system automatically skips. In the next game, if unfortunately struck a mine, the game is over. Players can click on the lower left corner of the flag, into the placed flag mode to mark the mine square. During the game, the system counts time and indicates how many flags are left to win.

## 2. Requirement Analysis

1. The game has three difficult level(easy, medium, hard);Different level has different number of mines(50,100,150).

2. When user click the block to play the game, the first clicked block should not be mine. Then the block would show how many mine in the surrounding block. If there is no any mine in the surrounding, the clicked block should spread until the total mine of next block is not 0.

3. When the player is failed, the all mine should be unfold and play the “bomb.wav”. If the player success, also play the related music. Then the system would tell the time cost.

4. If the player could sure the block is a mine, he can put the flag to mark the block.

5. The player can get how many block need to be clicked from the system.

6. The game should tell the user the detailed rule.

## 3. System Designs

 	Why I choose GreenFoot?

For the project, I select the GreenFoot to develop, because it is a full IDE which includes project management, auto-completion, syntax highlighting, and other tools common to most IDEs. It also allows developer to publish your work both on and offline.

The most important thing is that it support java and its ideology is object-oriented, it provide World and Actor object to build the game. So we can create 'actors' which live in 'worlds' to finish the MineSweeper program.

​	How I design the game?

In the java programming, everything could be thought like a project. I use a background picture as “MyWorld”, and evenly spread the block in “MyWorld”. Then every block is a small object inherited from Actor. I use a block array to manage it. Then I use recursion to get the surrounding number of that.

At the beginning of the game, we can see that there are three levels of button to select the game, and there are flag icon and question mark icon in the left and right corner respectively. When the user click one of the three buttons, the game is begin. System would randomly distribute the mine to the block. Then the play could enjoy the game.