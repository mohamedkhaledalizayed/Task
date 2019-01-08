package smile.khaled.mohamed.task.service.response.repo;

import com.google.gson.annotations.SerializedName;

public class RepoResponse{

	@SerializedName("tags_url")
	private String tagsUrl;

	@SerializedName("private")
	private boolean jsonMemberPrivate;

	@SerializedName("contributors_url")
	private String contributorsUrl;

	@SerializedName("notifications_url")
	private String notificationsUrl;

	@SerializedName("description")
	private String description;

	@SerializedName("subscription_url")
	private String subscriptionUrl;

	@SerializedName("keys_url")
	private String keysUrl;

	@SerializedName("branches_url")
	private String branchesUrl;

	@SerializedName("deployments_url")
	private String deploymentsUrl;

	@SerializedName("issue_comment_url")
	private String issueCommentUrl;

	@SerializedName("labels_url")
	private String labelsUrl;

	@SerializedName("subscribers_url")
	private String subscribersUrl;

	@SerializedName("releases_url")
	private String releasesUrl;

	@SerializedName("comments_url")
	private String commentsUrl;

	@SerializedName("stargazers_url")
	private String stargazersUrl;

	@SerializedName("id")
	private int id;

	@SerializedName("owner")
	private Owner owner;

	@SerializedName("archive_url")
	private String archiveUrl;

	@SerializedName("commits_url")
	private String commitsUrl;

	@SerializedName("git_refs_url")
	private String gitRefsUrl;

	@SerializedName("forks_url")
	private String forksUrl;

	@SerializedName("compare_url")
	private String compareUrl;

	@SerializedName("statuses_url")
	private String statusesUrl;

	@SerializedName("git_commits_url")
	private String gitCommitsUrl;

	@SerializedName("blobs_url")
	private String blobsUrl;

	@SerializedName("git_tags_url")
	private String gitTagsUrl;

	@SerializedName("merges_url")
	private String mergesUrl;

	@SerializedName("downloads_url")
	private String downloadsUrl;

	@SerializedName("url")
	private String url;

	@SerializedName("contents_url")
	private String contentsUrl;

	@SerializedName("milestones_url")
	private String milestonesUrl;

	@SerializedName("teams_url")
	private String teamsUrl;

	@SerializedName("fork")
	private boolean fork;

	@SerializedName("issues_url")
	private String issuesUrl;

	@SerializedName("full_name")
	private String fullName;

	@SerializedName("events_url")
	private String eventsUrl;

	@SerializedName("issue_events_url")
	private String issueEventsUrl;

	@SerializedName("languages_url")
	private String languagesUrl;

	@SerializedName("html_url")
	private String htmlUrl;

	@SerializedName("collaborators_url")
	private String collaboratorsUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("pulls_url")
	private String pullsUrl;

	@SerializedName("hooks_url")
	private String hooksUrl;

	@SerializedName("assignees_url")
	private String assigneesUrl;

	@SerializedName("trees_url")
	private String treesUrl;

	@SerializedName("node_id")
	private String nodeId;

	public void setTagsUrl(String tagsUrl){
		this.tagsUrl = tagsUrl;
	}

	public String getTagsUrl(){
		return tagsUrl;
	}

	public void setJsonMemberPrivate(boolean jsonMemberPrivate){
		this.jsonMemberPrivate = jsonMemberPrivate;
	}

	public boolean isJsonMemberPrivate(){
		return jsonMemberPrivate;
	}

	public void setContributorsUrl(String contributorsUrl){
		this.contributorsUrl = contributorsUrl;
	}

	public String getContributorsUrl(){
		return contributorsUrl;
	}

	public void setNotificationsUrl(String notificationsUrl){
		this.notificationsUrl = notificationsUrl;
	}

	public String getNotificationsUrl(){
		return notificationsUrl;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setSubscriptionUrl(String subscriptionUrl){
		this.subscriptionUrl = subscriptionUrl;
	}

	public String getSubscriptionUrl(){
		return subscriptionUrl;
	}

	public void setKeysUrl(String keysUrl){
		this.keysUrl = keysUrl;
	}

	public String getKeysUrl(){
		return keysUrl;
	}

	public void setBranchesUrl(String branchesUrl){
		this.branchesUrl = branchesUrl;
	}

	public String getBranchesUrl(){
		return branchesUrl;
	}

	public void setDeploymentsUrl(String deploymentsUrl){
		this.deploymentsUrl = deploymentsUrl;
	}

	public String getDeploymentsUrl(){
		return deploymentsUrl;
	}

	public void setIssueCommentUrl(String issueCommentUrl){
		this.issueCommentUrl = issueCommentUrl;
	}

	public String getIssueCommentUrl(){
		return issueCommentUrl;
	}

	public void setLabelsUrl(String labelsUrl){
		this.labelsUrl = labelsUrl;
	}

	public String getLabelsUrl(){
		return labelsUrl;
	}

	public void setSubscribersUrl(String subscribersUrl){
		this.subscribersUrl = subscribersUrl;
	}

	public String getSubscribersUrl(){
		return subscribersUrl;
	}

	public void setReleasesUrl(String releasesUrl){
		this.releasesUrl = releasesUrl;
	}

	public String getReleasesUrl(){
		return releasesUrl;
	}

	public void setCommentsUrl(String commentsUrl){
		this.commentsUrl = commentsUrl;
	}

	public String getCommentsUrl(){
		return commentsUrl;
	}

	public void setStargazersUrl(String stargazersUrl){
		this.stargazersUrl = stargazersUrl;
	}

	public String getStargazersUrl(){
		return stargazersUrl;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setOwner(Owner owner){
		this.owner = owner;
	}

	public Owner getOwner(){
		return owner;
	}

	public void setArchiveUrl(String archiveUrl){
		this.archiveUrl = archiveUrl;
	}

	public String getArchiveUrl(){
		return archiveUrl;
	}

	public void setCommitsUrl(String commitsUrl){
		this.commitsUrl = commitsUrl;
	}

	public String getCommitsUrl(){
		return commitsUrl;
	}

	public void setGitRefsUrl(String gitRefsUrl){
		this.gitRefsUrl = gitRefsUrl;
	}

	public String getGitRefsUrl(){
		return gitRefsUrl;
	}

	public void setForksUrl(String forksUrl){
		this.forksUrl = forksUrl;
	}

	public String getForksUrl(){
		return forksUrl;
	}

	public void setCompareUrl(String compareUrl){
		this.compareUrl = compareUrl;
	}

	public String getCompareUrl(){
		return compareUrl;
	}

	public void setStatusesUrl(String statusesUrl){
		this.statusesUrl = statusesUrl;
	}

	public String getStatusesUrl(){
		return statusesUrl;
	}

	public void setGitCommitsUrl(String gitCommitsUrl){
		this.gitCommitsUrl = gitCommitsUrl;
	}

	public String getGitCommitsUrl(){
		return gitCommitsUrl;
	}

	public void setBlobsUrl(String blobsUrl){
		this.blobsUrl = blobsUrl;
	}

	public String getBlobsUrl(){
		return blobsUrl;
	}

	public void setGitTagsUrl(String gitTagsUrl){
		this.gitTagsUrl = gitTagsUrl;
	}

	public String getGitTagsUrl(){
		return gitTagsUrl;
	}

	public void setMergesUrl(String mergesUrl){
		this.mergesUrl = mergesUrl;
	}

	public String getMergesUrl(){
		return mergesUrl;
	}

	public void setDownloadsUrl(String downloadsUrl){
		this.downloadsUrl = downloadsUrl;
	}

	public String getDownloadsUrl(){
		return downloadsUrl;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setContentsUrl(String contentsUrl){
		this.contentsUrl = contentsUrl;
	}

	public String getContentsUrl(){
		return contentsUrl;
	}

	public void setMilestonesUrl(String milestonesUrl){
		this.milestonesUrl = milestonesUrl;
	}

	public String getMilestonesUrl(){
		return milestonesUrl;
	}

	public void setTeamsUrl(String teamsUrl){
		this.teamsUrl = teamsUrl;
	}

	public String getTeamsUrl(){
		return teamsUrl;
	}

	public void setFork(boolean fork){
		this.fork = fork;
	}

	public boolean isFork(){
		return fork;
	}

	public void setIssuesUrl(String issuesUrl){
		this.issuesUrl = issuesUrl;
	}

	public String getIssuesUrl(){
		return issuesUrl;
	}

	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return fullName;
	}

	public void setEventsUrl(String eventsUrl){
		this.eventsUrl = eventsUrl;
	}

	public String getEventsUrl(){
		return eventsUrl;
	}

	public void setIssueEventsUrl(String issueEventsUrl){
		this.issueEventsUrl = issueEventsUrl;
	}

	public String getIssueEventsUrl(){
		return issueEventsUrl;
	}

	public void setLanguagesUrl(String languagesUrl){
		this.languagesUrl = languagesUrl;
	}

	public String getLanguagesUrl(){
		return languagesUrl;
	}

	public void setHtmlUrl(String htmlUrl){
		this.htmlUrl = htmlUrl;
	}

	public String getHtmlUrl(){
		return htmlUrl;
	}

	public void setCollaboratorsUrl(String collaboratorsUrl){
		this.collaboratorsUrl = collaboratorsUrl;
	}

	public String getCollaboratorsUrl(){
		return collaboratorsUrl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPullsUrl(String pullsUrl){
		this.pullsUrl = pullsUrl;
	}

	public String getPullsUrl(){
		return pullsUrl;
	}

	public void setHooksUrl(String hooksUrl){
		this.hooksUrl = hooksUrl;
	}

	public String getHooksUrl(){
		return hooksUrl;
	}

	public void setAssigneesUrl(String assigneesUrl){
		this.assigneesUrl = assigneesUrl;
	}

	public String getAssigneesUrl(){
		return assigneesUrl;
	}

	public void setTreesUrl(String treesUrl){
		this.treesUrl = treesUrl;
	}

	public String getTreesUrl(){
		return treesUrl;
	}

	public void setNodeId(String nodeId){
		this.nodeId = nodeId;
	}

	public String getNodeId(){
		return nodeId;
	}

	@Override
 	public String toString(){
		return 
			"RepoResponse{" + 
			"tags_url = '" + tagsUrl + '\'' + 
			",private = '" + jsonMemberPrivate + '\'' + 
			",contributors_url = '" + contributorsUrl + '\'' + 
			",notifications_url = '" + notificationsUrl + '\'' + 
			",description = '" + description + '\'' + 
			",subscription_url = '" + subscriptionUrl + '\'' + 
			",keys_url = '" + keysUrl + '\'' + 
			",branches_url = '" + branchesUrl + '\'' + 
			",deployments_url = '" + deploymentsUrl + '\'' + 
			",issue_comment_url = '" + issueCommentUrl + '\'' + 
			",labels_url = '" + labelsUrl + '\'' + 
			",subscribers_url = '" + subscribersUrl + '\'' + 
			",releases_url = '" + releasesUrl + '\'' + 
			",comments_url = '" + commentsUrl + '\'' + 
			",stargazers_url = '" + stargazersUrl + '\'' + 
			",id = '" + id + '\'' + 
			",owner = '" + owner + '\'' + 
			",archive_url = '" + archiveUrl + '\'' + 
			",commits_url = '" + commitsUrl + '\'' + 
			",git_refs_url = '" + gitRefsUrl + '\'' + 
			",forks_url = '" + forksUrl + '\'' + 
			",compare_url = '" + compareUrl + '\'' + 
			",statuses_url = '" + statusesUrl + '\'' + 
			",git_commits_url = '" + gitCommitsUrl + '\'' + 
			",blobs_url = '" + blobsUrl + '\'' + 
			",git_tags_url = '" + gitTagsUrl + '\'' + 
			",merges_url = '" + mergesUrl + '\'' + 
			",downloads_url = '" + downloadsUrl + '\'' + 
			",url = '" + url + '\'' + 
			",contents_url = '" + contentsUrl + '\'' + 
			",milestones_url = '" + milestonesUrl + '\'' + 
			",teams_url = '" + teamsUrl + '\'' + 
			",fork = '" + fork + '\'' + 
			",issues_url = '" + issuesUrl + '\'' + 
			",full_name = '" + fullName + '\'' + 
			",events_url = '" + eventsUrl + '\'' + 
			",issue_events_url = '" + issueEventsUrl + '\'' + 
			",languages_url = '" + languagesUrl + '\'' + 
			",html_url = '" + htmlUrl + '\'' + 
			",collaborators_url = '" + collaboratorsUrl + '\'' + 
			",name = '" + name + '\'' + 
			",pulls_url = '" + pullsUrl + '\'' + 
			",hooks_url = '" + hooksUrl + '\'' + 
			",assignees_url = '" + assigneesUrl + '\'' + 
			",trees_url = '" + treesUrl + '\'' + 
			",node_id = '" + nodeId + '\'' + 
			"}";
		}
}