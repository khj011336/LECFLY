<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="receiveBoard_wrapper">
        <div id="receiveBoard_content">
            <div class="receiveBoard_content_title">
                <span class=""></span>
                쿠폰적용은 어떤식으로 하는게 좋을까요?
                <span class="divider">|</span>
                <span class="receiveBoard_category">
                <a href="#">쿠폰</a></span>
                <span class="titleRight">
                <span class="readWriterTime">
                2020-04-10 15:52:48
                </span>
                </span>
            </div>
        <div id="writeInfo">
        <div id="readHead">
            <div class="readLeft">
                <i class="#">
                </i>
                <strong>
                    <a rel="#">김건우</a>
                </strong>
                <span class="receiveBoradgrade">일반회원</span>

            </div>
        </div>
        </div>
        <div id="receiveBoard_articleBody">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing tristique. Mi eget mauris pharetra et. Non tellus orci ac auctor augue. Elit at imperdiet dui accumsan sit. Ornare arcu dui vivamus arcu felis. Egestas integer eget aliquet nibh praesent. In hac habitasse platea dictumst quisque sagittis purus. Pulvinar elementum integer enim neque volutpat ac.
        </div>
        <div id="reply_count">댓글 1</div>
            <span class="divider">|</span>
            <div id="reply_selection">
                <select id="reply_select">
                    <option>등록순</option>
                    <option>조회순</option>
                </select>
            <span class="divider">|</span>
            <div id="receiveBoard_article_count">조회수 5</div>
            <span class="divider">|</span>
                <div id="receiveBoard_article_like">좋아요</div>
                <div id="receiveBoard_article_like">0</div>
        </div>
        <div id="receiveBoard_bottom">
            <form id="receiveBoard_write_commnet">
                    <p class="counter">250</p>
                        <textarea class="reply_statusBox" rows="5" cols="113" placeholder="댓글을 입력해주세요."></textarea>
                    <input type="button" id="receiveBoard_submit" class="receiveBoard_button"
                           title="댓글 쓰기" readonly value="댓글쓰기">
                    <ul class="posts">
                    </ul>
                    <script>
                var main = function() {
                    $('.receiveBoard_button').click(function() {
                       var post = $('.reply_statusBox').val();
                       $('<li>').text(post).prependTo('.posts');
                       $('.reply_statusBox').val('');
                       $('.counter').text('250');
                       $('.receiveBoard_button').addClass('disabled');
                    });
                    $('.reply_statusBox').keyup(function() {
                        var postLength =$(this).val().length;
                        var charactersLeft = 250 - postLength;
                        $('.counter').text(charactersLeft);
                        if (charactersLeft < 0) {
                            $('.receiveBoard_button').addClass('disabled');
                        } else if ( charactersLeft === 250) {
                            $('.receiveBoard_button').addClass('disabled');
                        } else {
                            $('.receiveBoard_button').removeClass('disabled');
                        }
                    });
                }
                $('.receiveBoard_button').addClass('disabled');
                $(document).ready(main)
            </script>
            </form>
        </div>
    </div>
</div>