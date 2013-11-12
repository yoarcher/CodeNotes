==== Recursive Solution ====

void preTravRec(Node *root){
	if(!root) return;
	cout << root->value << endl;
	preTravRec(root->left);
	preTravRec(root->right);
}

void inTravRec(Node *root){
	if(!root) return;
	inTravRec(root->left);
	cout << root->value << endl;
	inTravRec(root->right);
}

void postTravRec(Node *root){
	if(!root) return;
	inTravRec(root->left);
	inTravRec(root->right);
	cout << root->value << endl;
}


==== Iterative Solution ====

/* Visit node before visiting its children */
void preOrdTravItr(Node *root){
	stack<Node *> s;
	while(!s.empty() || root){
		if(root){
			/* Don't do any thing just visit node */
			cout << root->value << endl;

			/* Back up right child before visiting the left child */
			if(root->right) {
				s.push(root->right);
			}
			root = root->left;
		} else {

			/* If there is no left child, do same thing to right branch */
			root = s.top();
			s.pop();
		}
	}
}

/* Visit node if it does not have left child or its left child is visited */
void inOrdTravItr(Node *root){
	stack<Node *> s;
	while(!s.empty() || root){
		if(root){
			s.push(root);
			root = root->left;
		} else {
			/* node has no left child now */
			root = s.top();
			cout << root->value << endl;
			s.pop();
			root = root->right;
		}
	}
}

/* Visit node if it has no child or its children are both visited */
void postOrdTravItr(Node *root){
	if(!root) return;
	Node *cur = root;
	Node *prev = NULL; 	/* Previously visited node */
	stack<Node *> s;

	while(!s.empty() || cur){
		if(cur){
			s.push(cur);
			cur = cur->left;
		} else {
			/* node has no left child now */
			
			if(!s.top()->right || s.top()->right == prev){
				/* If node has no unvisited right child either, visit it */
				prev = s.top();
				cout << prev->value << endl;
				s.pop();
			} else {
				/* Otherwise, do the same thing to new found right child */
				cur = s.top()->right;
			}
		}
	}
}
