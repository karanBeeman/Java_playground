### How to configure two ssh key (personal and official)

## IF SHH SETUP DONE ALREADY FOR OFFICIAL ACCOUNT 

    ** Generate ssh key for personal account
         ssh-keygen -t ed25519 -C "your_email@example.com" -f ~/.ssh/id_ed25519_personal 
           This will generate something like this if you execute below cmd
                ~/.ssh/id_ed25519_personal
                ~/.ssh/id_ed25519_personal.pub
    ** nano ~/.ssh/config
         Host github-personal
           HostName github.com
           User git
           IdentityFile ~/.ssh/id_ed25519_personal
           IdentitiesOnly yes
           AddKeysToAgent yes
     ** Add the key to the ssh agent 
          ssh-add ~/.ssh/id_ed25519_personal    
     ** execute ssh-add -l  - to list and check keys are added
         now there should be two keys existing one and newly added one
    ** - cat ~/.ssh/id_ed25519_personal.pub - it will give something like this (repeat the process for both)
           * - ssh-ed25519 AAAAC3NzaC1lZDtfkdiCdfFyVOAY karanBeeman
           * - copy the above key add it in the github ssh section
    ** - test connection from below section should work for both 
          * - if not go to TRY THIS section

## IF NO SSH SETUP DONE ALREADY   

    **  ls ~/.ssh  // ls into ssh folder
          -- if ssh folder not present create one by using below
               -- mkdir -p ~/.ssh
    
    **  now Generate 2 ssh key if not already created (one for personal and one for official)
          * ssh-keygen -t ed25519 -C "your_email@example.com" -f ~/.ssh/id_ed25519_personal
          * ssh-keygen -t ed25519 -C "your_email@officialaddress.com" -f ~/.ssh/id_ed25519
         Above 2 cmd will create something like this
            ~/.ssh/id_ed25519
            ~/.ssh/id_ed25519.pub
            ~/.ssh/id_ed25519_personal
            ~/.ssh/id_ed25519_personal.pub
    
    **  nano ~/.ssh/config
           -- Add this
               Host github.com
                 AddKeysToAgent yes
                 IdentitiesOnly yes
                 IgnoreUnknown UseKeychain
                 IdentityFile ~/.ssh/id_ed25519
           -- Then add the personal shh key
                  -- nano ~/.ssh/config
                       // personal
                       Host github-personal
                         HostName github.com
                         User git
                         IdentityFile ~/.ssh/id_ed25519_personal
                         IdentitiesOnly yes
                         AddKeysToAgent yes
            -- if no key is already added, try adding it to the ssh agent
                 -- example:
                       ssh-add ~/.ssh/id_ed25519_personal  # add personal key
                       ssh-add ~/.ssh/id_ed25519           # add office key
            -- execute ssh-add -l  - to list and check keys are added
    ** - cat ~/.ssh/id_ed25519_personal.pub - it will give something like this (repeat the process for both)
           * - ssh-ed25519 AAAAC3NzaC1lZDtfkdiCdfFyVOAY karanBeeman
           * - copy the above key add it in the github ssh section
    ** Test connection section from below should work for both
           * - if not go to TRY THIS section

--------
 ## Test connection
        personal -  ssh -T git@github-personal
        office -    ssh -T git@github.com
-----
   
## Try this 
        ssh-add -D                          # remove all keys
        ssh-add ~/.ssh/id_ed25519_personal  # add personal key
        ssh-add ~/.ssh/id_ed25519           # add office key
        ssh-add -l                          # should list both



