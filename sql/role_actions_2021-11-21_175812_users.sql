/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET SQL_NOTES=0 */;
DROP TABLE IF EXISTS role_actions;
CREATE TABLE `role_actions` (
  `role_id` varchar(36) COLLATE utf8_spanish2_ci NOT NULL,
  `action_id` varchar(36) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`role_id`,`action_id`),
  KEY `rolact_to_action` (`action_id`),
  CONSTRAINT `rolact_to_action` FOREIGN KEY (`action_id`) REFERENCES `actions` (`id`),
  CONSTRAINT `rolact_to_role` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;