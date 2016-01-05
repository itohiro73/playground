g = require 'gulp'
browserSync = require 'browser-sync'
$ = require('gulp-load-plugins')()
path = require 'path'

handleError = (errors) ->
  console.log "Error!", errors.message

jadeTask = (lang) ->
  locales = require "./locale/#{lang}.json"

  g.src 'view/**/*.jade'
  .pipe $.jade {
    locals: locales
    pretty: true
  }
  .on('error', handleError)
  .pipe g.dest "#{lang}/"

  # gulp実行中にlocaleの変更を反映するため
  delete(require.cache[path.resolve("locale/#{lang}.json")])

g.task 'jade:ja', -> jadeTask("ja")
g.task 'jade:en', -> jadeTask("en")
g.task 'jade', ["jade:ja", "jade:en"]

g.task 'server', ['jade'], ->
  browserSync.init
    server:
      baseDir: "ja"

  g.watch('view/**/*.jade', ['jade'])
  g.watch('locale/*.json', ['jade'])
