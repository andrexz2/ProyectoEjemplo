package es.correos.soporte.minerva.proyectoejemplo.filter;

import java.security.KeyPair;
import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtSignatureValidationFilterTest {
	
	@Test
	public void emptyTest() {
		
	}
	
	public static String createValidJWT(String id, String issuer, String subject, long ttlMillis) {

		// The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.RS512;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"),
				"changeme".toCharArray());

		KeyPair privateKey = keyStoreKeyFactory.getKeyPair("jwt", "changeme".toCharArray());

		// Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
				.signWith(signatureAlgorithm, privateKey.getPrivate());

		// if it has been specified, let's add the expiration
		if (ttlMillis > 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	// Metodo main para poder generar tokens que se puedan utilizar para invocar al
	// servicio
	// sin necesidad de utilizar ISAM en los entornos de desarrollo.
	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(JwtSignatureValidationFilterTest.class);
		// token válido 1 día. Se puede ajustar para usar diferentes valores
		String oneDayToken = createValidJWT("id", "Correos", "UserId", 1000 * 60 * 60 * 24);
		log.info("TokenJWT: " + oneDayToken);
	}
}
