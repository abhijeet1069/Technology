Subversion is a server/client version control unlike Git which is distributed.
The server/client model of version control is focus around having one centralized location for the repositories.
Its more popular in the corporate world.

Checkout - Initial pulling of a specific revision or latest revision of a repository to store on a local machine.
    Via command Line:
        svn checkout svn://localhost/cmdline ./anshu
    Via Tortoise:
        Create Folder -> TortoiseSVN from menu -> aboveURL -> checkout

Working Copy - The copy of the files on the user's local machine that has been pulled from the respository.

Repository - Where the current and previous versions of a set of files are stored.

Revision - The state of the repository at a given point in time.

Head - The latest revsion.

Change - Modification to file under version control.

Commit - Submitting changes you have made on your working copy to be merged with the repository.
    Go to your client machine folder:
        mkdir branches tags trunk
        svn add branches tags trunk
        svn commit -m "first commit"
        
Merge - Applying 2 sets of changes to the same file or files at the same time.

Conflict - This occurs when a change to a file in version control could not merged automatically. 

Resolve - When a conflict occurs, a user must manually resolve the conflict by diffing the 2 files and select the changes to be committed.

Branch/Branching - The creation of a copy of set of files under version control at a specific point in time. Once brnached, the original set of files
                    and the branched set of files are managed independently from each other.

Label/Tag - A snapshot of a repository at a particular point in time.

Trunk - A line of development kept separate from branches and tags. In software development, this is usually where the latest version of the files are stored.

Export - Creation of copy of set of files under version control without any version control metadata.

Update - Retrieval of changes that have been made to the repository since the user last updated their working copy.

Create SVN server (Run CMD as admin):
    Start svnserver windows service:    
     sc create svnserver binpath= "C:\Program Files\TortoiseSVN\bin\svnserve.exe --service --root D:\Satyam\LearnSVN\repo" displayname="SVNServer" depend= Tcpip start= auto

    Delete service:
        sc delete svnserver

    Go to services and run (Make sure repo folder is created)

Configuring svnserver:
    svnadmin create D:\Satyam\LearnSVN\repo\cmdline
    Go to D:\Satyam\LearnSVN\repo\cmdline\conf\svnserve.conf
    Uncomment:
        anon-access = read
        auth-access = write
        password-db = passwd
    Go to passwd and create users:
        [users]
        satyam = satyamx
        anshu = anshux

