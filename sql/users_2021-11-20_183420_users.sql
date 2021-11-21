/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET SQL_NOTES=0 */;
DROP TABLE IF EXISTS users;
CREATE TABLE `users` (
  `id` varchar(36) NOT NULL COMMENT 'Primary Key',
  `username` varchar(30) NOT NULL COMMENT 'Username',
  `password` varchar(100) NOT NULL COMMENT 'Password',
  `name` varchar(200) DEFAULT NULL COMMENT 'User name',
  `last_name` varchar(400) DEFAULT NULL COMMENT 'User last name',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;