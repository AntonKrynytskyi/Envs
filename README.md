# Envs
Little utility for get common info about  CQ/AEM instances, which have been running. 

Step #1
Creation symlink:
    sudo ln -s fullPath /usr/local/bin/<command name>
Example:
    sudo ln -s /home/<user>/scripts/envs/envs /usr/local/bin/envs

Step #2
    sudo chmod +x /home/<user>/scripts/envs/<jar-file>

Folder '/home/<user>/scripts/envs' have to contain:
1. jar file
2. envs // bash script

----------------------------------------------------------------
As result you will see something like that:
----------------------------------------------------------------

<user>@<user>:~$ envs
|>>>>CQ/AEM.size=[2]
|------>Env#1:
|>>>>>Pid=20129
|>>>>Port=4503
|>>>DebugPort=N/A
|>>RunMods=publish,crx3,crx3tar
|>Path=/home/mrgr3n/aem-enviroment/dev-publisher

|------>Env#2:
|>>>>>Pid=24086
|>>>>Port=4502
|>>>DebugPort=30300
|>>RunMods=author,crx3,crx3tar
|>Path=/home/mrgr3n/aem-enviroment/dev-author

|>>>>>>>>>>[2]
<user>@<user>:~$
