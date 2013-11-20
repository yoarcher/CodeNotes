/* Tree Traversal Level by Level */

void PrintNodeByLevel(Node *root){
	queue<Node *> q;
	q.push(root);
	Node *temp;
	while(!q.empty()){
		temp = q.front();
		cout << temp->value << " ";
		q.pop();
		if(temp->left) q.push(temp->left);
		if(temp->right) q.push(temp->right);
	}
}