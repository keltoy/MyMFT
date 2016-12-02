package com.bjut.soft.pathParser;


public interface IASTVisitor {
	void visitPath(ASTPath path);
	void visitStep(ASTStep step);
	void visitPreds(ASTPreds preds);
}
