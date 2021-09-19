CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` char(45) NOT NULL,
  `user_type` char(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `banks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` char(45) NOT NULL,
  `usual_commission` decimal(4,2) NOT NULL,
  `legal_commission` decimal(4,2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `accounts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_bank` int NOT NULL,
  `id_user` int NOT NULL,
  `balance` decimal(15,3) NOT NULL,
  `currency` char(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `accounts_banks_id_fk` (`id_bank`),
  KEY `accounts_users_id_fk` (`id_user`),
  CONSTRAINT `accounts_banks_id_fk` FOREIGN KEY (`id_bank`) REFERENCES `banks` (`id`),
  CONSTRAINT `accounts_users_id_fk` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `transactions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_account_from` int NOT NULL,
  `id_account_to` int NOT NULL,
  `transaction_time` date DEFAULT NULL,
  `value` decimal(15,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `transactions_accounts_id_fk` (`id_account_from`),
  KEY `transactions_accounts_id_fk_2` (`id_account_to`),
  CONSTRAINT `transactions_accounts_id_fk` FOREIGN KEY (`id_account_from`) REFERENCES `accounts` (`id`),
  CONSTRAINT `transactions_accounts_id_fk_2` FOREIGN KEY (`id_account_to`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `currencies` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` char(3) NOT NULL,
  `value` decimal(15,3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `currencies_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
