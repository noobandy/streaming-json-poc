package in.anandm.quotes.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import in.anandm.quotes.model.Quote;

@Component
@Aspect
public class QuoteCacheAspect {
	private Quote cached;
	
	@Pointcut("execution(@in.anandm.quotes.aspect.QuoteCache public * *.*(..))")
	public void getQuote() {
		
	}
	
	@Around("getQuote()")
	public Quote beforeQuote(ProceedingJoinPoint joinPoint) {
		if(cached == null) {
			try {
				cached = (Quote) joinPoint.proceed();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return cached;
	}
}
