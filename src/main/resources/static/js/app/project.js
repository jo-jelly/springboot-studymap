var main = {
    init: function () {
        var _this = this;
        $('#btn-project_save').on('click', function () {
            _this.save();
        });
        $('#btn-project_update').on('click', function () {
            _this.update();
        });

        $('#btn-project_delete').on('click', function () {
                    _this.delete();
                });
        $('#btn-pcomment').on('click', function(){
                    _this.save2();
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
    save2 : function () {
        var data = {
            writer: $('#writer').val(),
            userId: $('#userId').val(),
            studyGroupId: $('#projectId').val(),
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
    update : function () {
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
    delete : function () {
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
    }

};
main.init();