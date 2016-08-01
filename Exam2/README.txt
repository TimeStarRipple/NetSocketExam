在Exam2文件中打开命令行窗口，执行下面一行命令
mvn clean compile exec:java -Dexec.mainClass="com.hand.zyb.App"

以上命令执行完成之后，在Exam2文件中打开新的命令行窗口，执行下面一行命令
mvn clean compile exec:java -Dexec.mainClass="com.hand.zyb.SocketClient"