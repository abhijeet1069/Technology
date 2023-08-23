package ch2.statelessServlet;

import java.math.BigInteger;

import net.jcip.annotations.ThreadSafe;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@ThreadSafe
public class StatelessFactorizer extends GenericServlet implements Servlet {

	public void service(ServletRequest req, ServletResponse resp) {
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factor(i);
		encodeIntoResponse(resp, factors);
	}
	void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
	}
	BigInteger extractFromRequest(ServletRequest req) {
		return new BigInteger("7");
	}
	BigInteger[] factor(BigInteger i) {
		// Doesn't really factor
		return new BigInteger[] { i };
	}
}