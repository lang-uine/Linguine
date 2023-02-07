insert into member (id, register_time, update_time, email, last_login_time, count, locked, period, name, nick_name, password, role, spec, user_name)
values (1, null, null, 'admin', null, 0, false, null,'admin', 'admin',   '$2a$12$pehci6O4NX2kq50jpyB4dedly5psClcTcGZw1kMtza1xJKnB2awwO', 'ADMIN', NULL, NULL);
insert into member (id, register_time, update_time, email, last_login_time, count, locked, period, name, nick_name, password, role, spec, user_name)
values (2, null, null, 'test', null, 0, false, null,'test', 'test', '$2a$12$Na/StTFUfKVVde8sXulqDO/wz0ykEmLJW1hxv0XVEIhxtrU6rAxMC', 'USER', NULL, NULL);
--
insert into
    post(ptype, post_id ,register_time, update_time, category, comments_cnt, contents, hit_cnt, owner, title, is_buying, is_expired, price, member_id)
    values('free', 1, DATE_ADD(NOW(), INTERVAL 1 MINUTE),DATE_ADD(NOW(), INTERVAL 1 MINUTE), 0, 0, 'test1', 0, 1, '자유 게시글1', null,null,null,1),
          ('trade', 2, DATE_ADD(NOW(), INTERVAL 2 MINUTE),DATE_ADD(NOW(), INTERVAL 2 MINUTE), 2, 0, 'test3', 0, 1, '거래 게시글2', 0,0,0,1),
          ('review', 3, DATE_ADD(NOW(), INTERVAL 3 MINUTE),DATE_ADD(NOW(), INTERVAL 3 MINUTE), 1, 0, 'test4', 0, 1, '리뷰 게시글3', null,null,null,1),
          ('trade', 4, DATE_ADD(NOW(), INTERVAL 4 MINUTE),DATE_ADD(NOW(), INTERVAL 4 MINUTE), 2, 0, 'test5', 0, 1, '거래 게시글4', 0,0,0,1),
          ('trade', 5, DATE_ADD(NOW(), INTERVAL 5 MINUTE),DATE_ADD(NOW(), INTERVAL 5 MINUTE), 2, 0, 'test6', 0, 1, '거래 게시글5', 0,0,0,1),
          ('free', 6, DATE_ADD(NOW(), INTERVAL 6 MINUTE),DATE_ADD(NOW(), INTERVAL 6 MINUTE), 0, 0, 'test7', 0, 1, '자유 게시글6', null,null,null,1),
          ('free', 7, DATE_ADD(NOW(), INTERVAL 7 MINUTE),DATE_ADD(NOW(), INTERVAL 7 MINUTE), 0, 0, 'test8', 0, 1, '자유 게시글7', null,null,null,1),
          ('trade', 8, DATE_ADD(NOW(), INTERVAL 8 MINUTE),DATE_ADD(NOW(), INTERVAL 8 MINUTE), 0, 0, 'test9', 0, 1, '거래 게시글8', 0,0,0,1),
          ('review', 9, DATE_ADD(NOW(), INTERVAL 8 MINUTE),DATE_ADD(NOW(), INTERVAL 9 MINUTE), 1, 0, 'test10', 0, 1, '리뷰 게시글9', null, null, null, 1),
          ('trade', 10, DATE_ADD(NOW(), INTERVAL 8 MINUTE),DATE_ADD(NOW(), INTERVAL 10 MINUTE), 0, 0, 'test11', 0, 1, '거래 게시글10', 0,0,0,1);
