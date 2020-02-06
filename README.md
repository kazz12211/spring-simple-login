# spring-simple-login

Spring Boot (2.2.4.RELEASE)でSpring Securityを使ったユーザー名とパスワードを使ったログイン機能の例。最小限の実装ですが、それ故にアプリケーションの雛形として参考になると思います。

元ネタは Spring Guides の [Securing a Web Application](https://spring.io/guides/gs/securing-web/) です。ガイドではUserDetailsServiceがInMemoryですが、それをJPAを使ったものに変更し、ユーザー登録機能を追加しています。

PostgreSQLデータベースで管理されたユーザー情報にJPAでアクセスします。

この例のキモの部分は、WebSecurityConfigクラスとUserDetailsServiceImplクラスに集約されています。パスワードはBCryptを使ってハッシュ化しています。