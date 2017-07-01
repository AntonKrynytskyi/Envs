# Envs : [DOWNLOAD](https://github.com/AntonKrynytskyi/Envs/raw/master/envs.zip)
## Little utility for get common info about  CQ/AEM instances, which have been running. 

### Step #1
- Creation symlink:
    sudo ln -s fullPath /usr/local/bin/**command name**
- Example:
    sudo ln -s /home/**your-user**/scripts/envs/envs /usr/local/bin/**envs**

### Step #2
 - sudo chmod +x /home/**your-user**/scripts/envs/**jar-file**

## Folder '/home/**your-user**/scripts/envs' have to contain:
1. jar file (env-info-0.0.1.jar)
2. envs // bash script

# As result you will see something like that:

```
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
```
[Link for DOWNLOAD JAR+Bash-script](https://github.com/AntonKrynytskyi/Envs/raw/master/envs.zip)
