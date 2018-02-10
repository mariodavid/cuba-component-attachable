package de.diedavids.cuba.attachable.web.attachment

import com.haulmont.cuba.core.entity.FileDescriptor
import com.haulmont.cuba.gui.AppConfig
import com.haulmont.cuba.gui.components.AbstractEditor
import com.haulmont.cuba.gui.components.Embedded
import com.haulmont.cuba.gui.components.Frame
import com.haulmont.cuba.gui.export.ExportFormat
import com.haulmont.cuba.gui.export.FileDataProvider
import com.haulmont.cuba.web.WebConfig
import de.diedavids.cuba.attachable.entity.Attachment
import groovy.transform.CompileStatic

import javax.inject.Inject

@CompileStatic
class AttachmentPreview extends AbstractEditor<Attachment> {


    @Inject
    Embedded attachmentPreviewViewer

    @Inject
    WebConfig webConfig

    @Override
    protected void postInit() {
        setPreviewCaption()
        fileExtensionSupported ? previewFile() : downloadFile()
    }

    protected setPreviewCaption() {
        setCaption(formatMessage('attachmentPreview', item.name))
    }

    protected previewFile() {
        attachmentPreviewViewer.setSource(file.name, new FileDataProvider(file))
    }

    protected boolean isFileExtensionSupported() {
        webConfig.viewFileExtensions.contains(file.extension)
    }

    protected FileDescriptor getFile() {
        item.file
    }

    void downloadFile() {
        showNotification(formatMessage('attachmentDownloaded'), Frame.NotificationType.HUMANIZED)
        AppConfig.createExportDisplay(this).show(file,ExportFormat.OCTET_STREAM)
    }
}