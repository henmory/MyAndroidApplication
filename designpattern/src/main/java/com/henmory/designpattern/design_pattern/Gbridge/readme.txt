
1.桥接模式链接的是两个对象维度，即品牌和尺寸，而且两个维度都会发生变化

2.策略模式是一个行为模式，它封装的是行为的算法族

3.桥接模式中是包含策略模式的

4.为什么不把品牌和大小两个维度都提取出来，再生成一个类，依赖这两个维度，以后继续学习

5.桥接模式解决的是两个维度同时增加，会导致类爆炸

6.但是为什么是一个维护持有另一个维度的引用，需要以后继续学习

7.感觉桥接模式完全可以再添加一个类，这样再增加其他唯独更容易

8.桥接模式定义：将抽象与实现分离,例如window是抽象，它的具体实现是PhoneWindow，而与抽象相连的则是WindowManager

9.即window中持有windowManager的引用，二者发生联系