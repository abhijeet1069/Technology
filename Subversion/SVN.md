Subversion is a server/client version control unlike Git which is distributed.
The server/client model of version control is focus around having one centralized location for the repositories.
Its more popular in the corporate world.

Checkout
    Initial pulling of a specific revision or latest revision of a repository to store on a local machine.
    Via command Line:
        svn checkout svn://localhost/cmdline ./anshu
    Via Tortoise:
        Create Folder -> TortoiseSVN from menu -> aboveURL -> checkout

Working Copy
    The copy of the files on the user's local machine that has been pulled from the respository.

Repository
    Where the current and previous versions of a set of files are stored.

Revision
    The state of the repository at a given point in time.

Head
    The latest revsion.

Change
    Modification to file under version control.

Commit
    Submitting changes you have made on your working copy to be merged with the repository.
        Go to your client machine folder:
            mkdir branches tags trunk
            svn add branches tags trunk
            svn commit -m "first commit"
        Commit as a different user:
            svn commit --username satyam --password satyamx
        
Merge
    Applying 2 sets of changes to the same file or files at the same time.

Conflict 
    This occurs when a change to a file in version control could not merged automatically. (Similar, to my call charging debacle.)
    Update to latest version before editing to resolve conflict.
    Resolving Conflict:
        svn update -> postpone -> keep the files you want to keep then update.

Resolve
    When a conflict occurs, a user must manually resolve the conflict by diffing the 2 files and select the changes to be committed.

Branch/Branching 
    The creation of a copy of set of files under version control at a specific point in time. Once branched, the original set of files and the branched set of files are managed independently from each other.
        svn copy ./trunk ./tags/tag1
        Then commit to add changes.

    Show version where branch is added:
        svn log --stop-on-copy

    Merging changes
        svn merge -r 12:13 svn://localhost/commandline/branches/branch1

        Adding tag directly in server:
            svn copy svn://localhost/commandline/trunk svn://localhost/commandline/tags/tag2 --username user1 --password password1

Label/Tag
    A snapshot of a repository at a particular point in time.

Trunk
    A line of development kept separate from branches and tags. In software development, this is usually where the latest version of the files are stored.

Export
    Creation of copy of set of files under version control without any version control metadata.

Update 
    Retrieval of changes that have been made to the repository since the user last updated their working copy.
        svn update

Status
    svn status
        ? - file/directory inside working copy but not not in the repository
        A - file/directory is going to be added when we next commit our change
        M - File has been modified since our last update
        D - On next update this file/directory will be deleted
        C - file in conflict
        ! - File in verison control that is not in local directory

Add to local repository:
    To be done for new files/folders. No need to add everytime like git.
    svn add <directory/file>

Creating SVN server (Run CMD as admin):
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

