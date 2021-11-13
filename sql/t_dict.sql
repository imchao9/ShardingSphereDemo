CREATE TABLE `t_dict` (
    `dict_id` bigint NOT NULL,
    `cstatus` varchar(10) NOT NULL,
    `ustatus` varchar(50) NOT NULL,
    `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `t_dict_1` (
    `dict_id` bigint NOT NULL,
    `cstatus` varchar(10) NOT NULL,
    `ustatus` varchar(50) NOT NULL,
    `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `t_dict_2` (
    `dict_id` bigint NOT NULL,
    `cstatus` varchar(10) NOT NULL,
    `ustatus` varchar(50) NOT NULL,
    `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;