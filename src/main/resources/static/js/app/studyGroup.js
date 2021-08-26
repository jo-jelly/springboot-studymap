var main = {
    init: function () {
        var _this = this;
        $('#btn-study_save').on('click', function () {
            _this.save();
        });
        $('#btn-study_update').on('click', function () {
            _this.update();
        });

        $('#btn-study_delete').on('click', function () {
                    _this.delete();
                });
        $('#btn-comment').on('click', function(){
                    _this.scomment();
                });
         $('#btn-project_save').on('click', function(){
           _this.project_save();
        });
        $('#btn-project_update').on('click', function () {
            _this.project_update();
        });

        $('#btn-project_delete').on('click', function () {
           _this.project_delete();
                });
        $('#btn-pcomment').on('click', function(){
           _this.pcomment();
                });
        $('#btn-forum_save').on('click', function () {
            _this.forum_save();
        });
        $('#btn-forum_update').on('click', function () {
            _this.forum_update();
        });

        $('#btn-forum_delete').on('click', function () {
                    _this.forum_delete();
                });
        $('#btn-fcomment').on('click', function(){
           _this.fcomment();
                });

    },

    save : function () {
        var data = {
            studyType: $(':radio[name="studyType"]:checked').val(),
            member: $('select#member').val(),
            area: $('select#area').val(),
            state: $('#state').val(),
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val(),
            userId: $('#userId').val(),
            views: $('#views').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/studyGroup',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/studyGroup';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    scomment : function () {
        var data = {
            writer: $('#writer').val(),
            userId: $('#userId').val(),
            studyGroupId: $('#studyGroupId').val(),
            content: $('#content').val()
        };
        var id = $('#id').val();
        $.ajax({
            type:  'POST',
            url: '/api/v1/comment',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 등록되었습니다.');
            window.location.href = '/studyGroup/view/'+id;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    fcomment : function () {
        var data = {
            writer: $('#writer').val(),
            userId: $('#userId').val(),
            forumId: $('#forumId').val(),
            content: $('#content').val()
        };
        var id = $('#id').val();
        $.ajax({
            type:  'POST',
            url: '/api/v1/fcomment',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 등록되었습니다.');
            window.location.href = '/forum/view/'+id;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/studyGroup/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/studyGroup/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    project_save : function () {
            var data = {
                studyType: $(':radio[name="studyType"]:checked').val(),
                member: $('select#member').val(),
                area: $('select#area').val(),
                state: $('#state').val(),
                title: $('#title').val(),
                author: $('#author').val(),
                content: $('#content').val(),
                userId: $('#userId').val(),
                views: $('#views').val()
            };

            $.ajax({
                type: 'POST',
                url: '/api/v1/project',
                dataType: 'json',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('글이 등록되었습니다.');
                window.location.href = '/project';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        },

    pcomment : function () {
        var data = {
            writer: $('#writer').val(),
            userId: $('#userId').val(),
            projectId: $('#projectId').val(),
            content: $('#content').val()
        };
        var id = $('#id').val();
        $.ajax({
            type:  'POST',
            url: '/api/v1/pcomment',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 등록되었습니다.');
            window.location.href = '/project/view/'+id;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    project_update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/project/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/project';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    project_delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/project/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/project';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    forum_save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val(),
            userId: $('#userId').val(),
            views: $('#views').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/forum',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/forum';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    forum_update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/forum/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/forum';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    forum_delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/forum/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/forum';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

};
main.init();